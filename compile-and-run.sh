#!/bin/bash

echo "=== Compiling Erasmus Journey Companion ==="
cd src/main/java
javac com/erasmus/*/*.java com/erasmus/main/*.java

if [ $? -eq 0 ]; then
    echo "✓ Compilation successful!"
    echo ""
    echo "=== Running Demo ==="
    echo ""
    java com.erasmus.main.ErasmusJourneyDemo
else
    echo "✗ Compilation failed!"
    exit 1
fi
