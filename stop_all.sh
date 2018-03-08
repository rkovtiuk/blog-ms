#!/usr/bin/env bash
curl -X POST localhost:8000/shutdown #core
curl -X POST localhost:8888/shutdown #auth
curl -X POST localhost:9001/shutdown #user
curl -X POST localhost:9002/shutdown #notification
curl -X POST localhost:9003/shutdown #blog
curl -X POST localhost:9004:shutdown #web-ui