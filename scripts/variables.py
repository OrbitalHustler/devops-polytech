#!/usr/bin/env python

import sys
import os


DIR_SCRIPTS = os.path.dirname(os.path.realpath(__file__))
DIR_ROOT = os.path.dirname(os.path.normpath(DIR_SCRIPTS))

DIR_ISLAND = os.path.dirname(os.path.normpath(DIR_ROOT + '/island'))
DIR_SPOON_REWRITER = os.path.dirname(os.path.normpath(DIR_ROOT + '/spoon_rewriter'))
DIR_OUT = os.path.dirname(os.path.normpath(DIR_ROOT + '/out'))

print (DIR_SCRIPTS)
print (DIR_ROOT)
print (DIR_OUT)
print (DIR_ROOT + '/island')
