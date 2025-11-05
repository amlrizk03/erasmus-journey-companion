#!/bin/bash

# Application 1: Check if a number is prime
echo "Check if number is prime"
read -p "Enter a number: " num

if [ $num -lt 2 ]; then
    echo "$num is not prime"
else
    prime=1
    i=2
    while [ $i -lt $num ]; do
        if [ $((num % i)) -eq 0 ]; then
            prime=0
            break
        fi
        i=$((i + 1))
    done
    
    if [ $prime -eq 1 ]; then
        echo "$num is prime"
    else
        echo "$num is not prime"
    fi
fi

echo ""

# Application 2: First N prime numbers
echo "First N prime numbers"
read -p "Enter N: " n

echo "The first $n primes:"
count=0
number=2

while [ $count -lt $n ]; do
    prime=1
    i=2
    while [ $i -lt $number ]; do
        if [ $((number % i)) -eq 0 ]; then
            prime=0
            break
        fi
        i=$((i + 1))
    done
    
    if [ $prime -eq 1 ]; then
        echo -n "$number "
        count=$((count + 1))
    fi
    number=$((number + 1))
done

echo ""
echo ""

# Application 3: Fibonacci sequence
echo "Fibonacci sequence"
read -p "Enter N: " n

echo "First $n terms:"
a=0
b=1

for ((i=0; i<n; i++)); do
    echo -n "$a "
    next=$((a + b))
    a=$b
    b=$next
done

echo ""
