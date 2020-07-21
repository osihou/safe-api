#!/bin/bash

curl -X POST localhost:8080/locations -H 'Content-type:application/json' -d '{"name":"sadsa","city":"dssas","street":"v","num":"1","postal_code":"1","type":"v","security_rate":1.0,"STAFF_WEARING_MASKS":1.0,"SANITIZER_AV":1.0,"DIST_KEPT":1.0,"other":1.0,"isopen":false,"latitude":1.0,"longitude":1.0}'
