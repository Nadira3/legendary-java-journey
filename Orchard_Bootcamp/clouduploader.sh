#!/bin/bash 
# the above line is the shebang to enable the script use bash if used without
# the bash command prompt from the command line
#
#
# CloudUploader CLI
# A bash-based  CLI tool that allows users to quickly upload their files to
# a specfied cloud storage solution seamlessly


# help function
show_help() {
	echo "Usage: $0 [options] [additional_arguments]"
	echo "Options:"
	echo "  -d DIR     Set the target cloud directory (optional)"
	echo "  -s CLASS   Set the storage class (optional)"
	echo "  -h         Display this help message"
}

# Check if the number of arguments is greater than 1
if [[ $# -lt 1 ]]; then
	echo "Error: At least one argument is required."
	show_help
	exit 1
fi


# Tool specified for this project is azure
TOOL="az"

# Check if az CLI is installed
if ! command -v $TOOL &> /dev/null; then
	echo "$TOOL is not installed. Please install the $TOOL CLI and try again."
	exit 1
fi

# Log in to Cloud Provider interactively
$TOOL login


# Define variables for options and their defaults
container_name=""
storage_class=""
additional_options=""

echo "Parsing command line arguments..."

# Parse options using getopts
while getopts "d:s:o:h:" opt; do
	case $opt in
		d)
			container_name="$OPTARG"
			;;
		s)
			storage_class="$OPTARG"
            		;;
	        o)
			additional_options="$OPTARG"
			;;
	        h)
			show_help
			exit 0
			;;
		\?)
			echo "Invalid option: -$OPTARG" >&2
			exit 1
			;;
	esac
done

# Set default container name to "home" if not provided
if [[ -z "$container_name" ]]; then
    container_name="home"
    echo "Container name not provided. Defaulting to container name: home"
fi

# Set default storage class (access tier) to "Hot" if not provided
if [[ -z "$storage_class" ]]; then
    storage_class="Hot"
    echo "Storage class not provided. Defaulting to access tier: Hot"
fi

# Shift the positional parameters to access file names
shift $((OPTIND - 1))

# At this point, $@ contains only the file names to upload

# Parse the command line for arguments and check if files exists and have a valid path
for file_name in "$@"; do
	echo "checking if $file_name exists and is a valid path"

	if [[ -e "$file_name" ]] && [[ -f "$file_name" ]]; then
		echo "File exists. Uploading $file_name...." # debugging messages
		
		# Perform the upload using Azure CLI
		echo "Uploading file: $file_name to container: $container_name with access tier: $storage_class"

		# Get the size of the file for the progress bar
		file_size=$(stat --format="%s" "$file_path")
		
		# Modify the command based on your needs and the options parsed
		# Use pv to monitor the file upload progress
		pv -p -s $file_size "$file_path" | $TOOL storage blob upload \
			--container-name "$container_name" \
			--file "-" \
			--name "$(basename "$file_name")" \
			--access-tier "$storage_class" \
			$additional_options

		# Check the exit status of the last command
		if [[ $? -eq 0 ]]; then
		    echo "$file_name upload completed successfully!"
		else
		    echo "$file_name upload failed! Please check for errors."
		fi
	else
		echo "$file_name not found. Check file path or spelling and include file path is file is not\
			in the current directory!"
	fi
done

echo "File upload complete!"
