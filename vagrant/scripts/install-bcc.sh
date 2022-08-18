#!/bin/bash

set -eux

sudo apt-get update
sudo apt-get install -y bpfcc-tools "linux-headers-$(uname -r)"
sudo apt-get install -y sysstat
sudo apt-get install -y maven
sudo apt-get install -y git

