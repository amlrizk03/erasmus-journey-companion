#!/bin/bash

# Linux Commands Homework
# This script runs commands and saves both commands and outputs

OUTPUT_FILE="homework_submission.txt"

# Clear the output file
> $OUTPUT_FILE

# Function to run a command and save it with output
run_and_save() {
    echo "$ $1" >> $OUTPUT_FILE
    eval $1 >> $OUTPUT_FILE
    echo "" >> $OUTPUT_FILE
}

# Add header
echo "======================================" >> $OUTPUT_FILE
echo "Linux Commands Homework Submission" >> $OUTPUT_FILE
echo "Date: $(date)" >> $OUTPUT_FILE
echo "======================================" >> $OUTPUT_FILE
echo "" >> $OUTPUT_FILE

# Example commands - Replace these with your actual homework commands
run_and_save "pwd"
run_and_save "whoami"
run_and_save "date"
run_and_save "ls -l"
run_and_save "uname -a"

echo "Output saved to $OUTPUT_FILE"
cat $OUTPUT_FILE
