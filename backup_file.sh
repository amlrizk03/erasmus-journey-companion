#!/bin/bash

# Exercise Part 1: Backup file script

# Get filename from user
read -p "Enter file name: " filename

# Check if file exists
if [ ! -f "$filename" ]; then
    echo "Error: File does not exist!"
    exit 1
fi

# Create backup filename with current date
date=$(date +%Y%m%d)
backup="$filename.bak.$date"

# Check if backup already exists
if [ -f "$backup" ]; then
    read -p "Backup file already exists. Do you want to replace it? (y/n): " answer
    if [ "$answer" != "y" ]; then
        echo "Backup cancelled"
        exit 0
    fi
fi

# Copy file to backup
cp "$filename" "$backup"

echo "Backup created: $backup"
echo "Original file: $filename"
ls -l "$filename" "$backup"
