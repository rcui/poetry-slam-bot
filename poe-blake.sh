#!/bin/sh
java -jar makeWords.jar src/main/resources/trainer3.txt src/main/resources/words.txt
java -jar poetry-slam-1.0.0.jar src/main/resources/blake.txt src/main/resources/out.txt