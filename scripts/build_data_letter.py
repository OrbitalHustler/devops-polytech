#!/usr/bin/env python

import random
import os
import sys
#import yaml


def parseYaml(filepath):
    mat = []
    inData = 0
    with open(filepath) as input:
        for line in input:
            line = line.strip()
            if line.startswith('data'):
                inData = 1
            if inData == 1:
                if line.endswith(']'):
                    inData = 0
                line = line.replace(',', '')
                line = line.split()
                for i in line:
                    try:
                        mat.append(int(i))
                    except ValueError:
                        pass

    if len(mat) == 256:
        return mat;

    return None

# recup nom dossier images et nom fichier de sortie
if len(sys.argv) < 3:
    print("usage:", sys.argv[0], "DIR [MORE_DIRS] DEST")
    sys.exit(0)

out = sys.argv[len(sys.argv) - 1]
if not out.endswith('.data'):
    out = out + '.data'

# shuffle l'ordre des fichiers pour avoir des data dans le desordre
files = []
for dir in sys.argv[1:-1]:
    for file in os.listdir(dir):
        if file.endswith('.yml'):
            files.append(dir.rstrip('/') + '/' + file)

print(len(files), "files")
random.shuffle(files)

f = open(out, 'w+')
print("outputing into", out)

# parser les fichiers
for file in files:
    if file.lower().endswith('.yaml') or file.lower().endswith('.yml'):
        data = parseYaml(file)
        if data != None:
            # prendre la premiere lettre du nom de fichier
            f.write(file.split('/')[-1] [0].upper())
            for i in data:
                f.write(',')
                f.write(str(i))
            f.write('\n')
f.close()
