#!/usr/bin/env bash

# generate keypair
openssl genrsa -out keypair.pem 2048

# extract public key
openssl rsa -in keypair.pem -pubout -outform PEM -out public-key.pem

# encrypt string
echo $SECRET_TO_PASS | openssl rsautl -inkey $PUBLIC_KEY -pubin -encrypt | base64 -w 0

# decrypt string
echo $ENCRYPTED_TEXT | base64 -d | openssl rsautl -inkey $PRIVATE_KEY -decrypt
