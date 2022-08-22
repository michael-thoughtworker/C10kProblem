#!/bin/bash

set -eux

sudo apt-get update
sudo apt-get install -y bpfcc-tools "linux-headers-$(uname -r)"
sudo apt-get install -y sysstat
sudo apt-get install -y maven
sudo apt-get install -y git
sudo curl -L "https://github.com/docker/compose/releases/download/1.29.2/docker-compose-$(uname -s)-$(uname -m)" -o /usr/local/bin/docker-compose
sudo chmod +x /usr/local/bin/docker-compose


