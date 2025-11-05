#!/bin/bash

# This will run applications.sh and save output to a file

echo "Running applications..."
echo "Inputs: 17 for prime check, 10 for primes, 12 for fibonacci"
echo ""

# Run with sample inputs and save to file
echo -e "17\n10\n12" | bash applications.sh | tee homework_output.txt

echo ""
echo "Output saved to homework_output.txt"
echo "You can download it and submit to Moodle!"
