#!/bin/bash

# Lab Exercises - All in one script

echo "========================================="
echo "Exercise 1: Run some commands from PPT"
echo "========================================="
pwd
whoami
ls
date
echo ""

echo "========================================="
echo "Exercise 2: Ping www.google.com"
echo "========================================="
if command -v ping &> /dev/null; then
    ping -c 4 www.google.com
else
    echo "Note: ping command - ping -c 4 www.google.com"
    echo "(ping not available in this environment)"
fi
echo ""

echo "========================================="
echo "Exercise 3: Create folder Music in Documents"
echo "========================================="
mkdir -p ~/Documents/Music
echo "Created: ~/Documents/Music"
ls -l ~/Documents/
echo ""

echo "========================================="
echo "Exercise 4: Copy a file to another location"
echo "========================================="
# Create a test file first
echo "This is a test file" > testfile.txt
echo "Created testfile.txt"
cp testfile.txt testfile_copy.txt
echo "Copied testfile.txt to testfile_copy.txt"
ls -l testfile*
echo ""

echo "========================================="
echo "Exercise 5: Copy a directory to new destination"
echo "========================================="
mkdir source_dir
echo "test content" > source_dir/file1.txt
echo "Created source_dir with file1.txt inside"
cp -r source_dir destination_dir
echo "Copied source_dir to destination_dir"
ls -l destination_dir/
echo ""

echo "========================================="
echo "Exercise 6: Delete a file"
echo "========================================="
rm testfile_copy.txt
echo "Deleted testfile_copy.txt"
ls -l testfile*
echo ""

echo "========================================="
echo "Exercise 7: Delete directory with subdirectories"
echo "========================================="
mkdir -p test_delete/subdir1/subdir2
echo "file" > test_delete/file1.txt
echo "file" > test_delete/subdir1/file2.txt
echo "Created test_delete directory with subdirectories and files"
rm -rf test_delete
echo "Deleted test_delete and all its contents"
echo ""

echo "========================================="
echo "Exercise 8: Move file to another folder"
echo "========================================="
mkdir folder1 folder2
echo "sample content" > folder1/myfile.txt
echo "Created folder1/myfile.txt"
mv folder1/myfile.txt folder2/
echo "Moved myfile.txt from folder1 to folder2"
ls -l folder2/
echo ""

echo "========================================="
echo "Exercise 9: Rename the moved file"
echo "========================================="
mv folder2/myfile.txt folder2/renamed_file.txt
echo "Renamed myfile.txt to renamed_file.txt"
ls -l folder2/
echo ""

echo "========================================="
echo "All exercises completed!"
echo "========================================="
