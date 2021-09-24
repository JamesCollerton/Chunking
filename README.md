# Chunking

The purpose of this repository is to give a small example of how we can chunk data in order to be sent over HTTP and stored. We have a sample image stored in the `sample-image` folder, which can be split using the `split -b 700 sample-image.jpg` command. This creates two files of around `700B` which we will store separately in our application.

We `base64` encode these files using the `base64` command, then sending them in a `POST` request to the endpoint `/chunk`, with message request body:

```
{
    "chunkName": "Name of chunk",
    "base64Bytes":"base64 encoded string"
}
```

We will receive a response with the `id` enclosed. We should then be able to use the `GET` endpoint with this `id` to return the `base64` encoded body, which we can decode. Doing this for both files should leave us with two more files we can reassemble using the `cat received_* > received.jpg`.
