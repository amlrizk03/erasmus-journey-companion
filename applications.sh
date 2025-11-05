#!/bin/bash

# Mathematical Applications

# Function to check if a number is prime
check_prime() {
    echo "=== Check if a Number is Prime ==="
    read -p "Enter a number: " num
    
    if [ $num -lt 2 ]; then
        echo "$num is not a prime number"
        return
    fi
    
    is_prime=1
    for ((i=2; i*i<=num; i++)); do
        if [ $((num % i)) -eq 0 ]; then
            is_prime=0
            break
        fi
    done
    
    if [ $is_prime -eq 1 ]; then
        echo "$num is a prime number"
    else
        echo "$num is not a prime number"
    fi
}

# Function to print first N prime numbers
print_n_primes() {
    echo "=== Print First N Prime Numbers ==="
    read -p "Enter N (number of primes to display): " n
    
    count=0
    num=2
    
    echo "First $n prime numbers:"
    while [ $count -lt $n ]; do
        is_prime=1
        for ((i=2; i*i<=num; i++)); do
            if [ $((num % i)) -eq 0 ]; then
                is_prime=0
                break
            fi
        done
        
        if [ $is_prime -eq 1 ]; then
            echo -n "$num "
            count=$((count + 1))
        fi
        num=$((num + 1))
    done
    echo ""
}

# Function to print first N Fibonacci numbers
print_fibonacci() {
    echo "=== Print First N Fibonacci Numbers ==="
    read -p "Enter N (number of Fibonacci terms): " n
    
    if [ $n -lt 1 ]; then
        echo "N must be at least 1"
        return
    fi
    
    a=0
    b=1
    
    echo "First $n terms of Fibonacci sequence:"
    for ((i=1; i<=n; i++)); do
        echo -n "$a "
        temp=$a
        a=$b
        b=$((temp + b))
    done
    echo ""
}

# Main menu
while true; do
    echo ""
    echo "======================================="
    echo "  Mathematical Applications Menu"
    echo "======================================="
    echo "1. Check if a number is prime"
    echo "2. Print first N prime numbers"
    echo "3. Print first N Fibonacci numbers"
    echo "4. Exit"
    echo "======================================="
    read -p "Choose an option (1-4): " choice
    echo ""
    
    case $choice in
        1)
            check_prime
            ;;
        2)
            print_n_primes
            ;;
        3)
            print_fibonacci
            ;;
        4)
            echo "Goodbye!"
            exit 0
            ;;
        *)
            echo "Invalid option. Please choose 1-4."
            ;;
    esac
done
