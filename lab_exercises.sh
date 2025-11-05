#!/bin/basCh

echo "Lab 5: Computer Networks"

pwd
whoami
ls
date

if command -v ping &> /dev/null; then
    ping -c 4 www.google.com
else
    echo "Note: ping command - ping -c 4 www.google.com"
    echo "(ping not available in this environment)"
fi
echo ""

mkdir -p ~/Documents/Music
echo "Created: ~/Documents/Music"
ls -l ~/Documents/
echo ""

echo testfile.txt
cp testfile.txt testfile_copy.txt
ls -l testfile*
echo ""

mkdir source_dir
echo "test content" > source_dir/file1.txt
cp -r source_dir destination_dir
ls -l destination_dir/
echo ""
rm testfile_copy.txt

mkdir -p test_delete/subdir1/subdir2
echo "file" > test_delete/file1.txt
echo "file" > test_delete/subdir1/file2.txt
echo "Created test_delete directory with subdirectories and files"
rm -rf test_delete


mkdir folder1 folder2
echo "sample content" > folder1/myfile.txt
mv folder1/myfile.txt folder2/

ls -l folder2/
echo ""

mv folder2/myfile.txt folder2/renamed_file.txt
echo "Renamed myfile.txt to renamed_file.txt"
ls -l folder2/
