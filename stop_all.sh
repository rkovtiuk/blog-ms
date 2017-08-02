#!/usr/bin/env bash
curl -X POST localhost:9001/shutdown
curl -X POST localhost:9002/shutdown
curl -X POST localhost:9003/shutdown