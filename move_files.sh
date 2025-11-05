#!/bin/bash

# Exercise Part 2: Move files script

# Create old directory if it doesn't exist
if [ ! -d "old" ]; then
    mkdir old
    echo "Created 'old' directory"
fi

# Create trash directory if it doesn't exist
if [ ! -d "trash" ]; then
    mkdir trash
    echo "Created 'trash' directory"
fi

# Move command line arguments to old directory
if [ $# -eq 0 ]; then
    echo "No files provided to move to old directory"
else
    echo "Moving files to old directory..."
    for file in "$@"; do
        if [ -f "$file" ]; then
            mv "$file" old/
            echo "Moved: $file"
        else
            echo "File not found: $file"
        fi
    done
fi

echo ""
echo "Files in old directory:"
ls -l old/

# Move a file inside trash directory
echo ""
read -p "Enter filename to move to trash: " trashfile

if [ -f "$trashfile" ]; then
    mv "$trashfile" trash/
    echo "Moved $trashfile to trash directory"
elif [ -f "old/$trashfile" ]; then
    mv "old/$trashfile" trash/
    echo "Moved $trashfile from old to trash directory"
else
    echo "File not found: $trashfile"
fi

echo ""
echo "Files in trash directory:"
ls -l trash/
