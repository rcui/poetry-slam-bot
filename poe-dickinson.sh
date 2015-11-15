#!/bin/sh
java -jar makeWords.jar src/main/resources/trainer1.txt src/main/resources/words.txt
java -jar poetry-slam-1.0.0.jar src/main/resources/dickinson.txt src/main/resources/out.txt