
import firebase_admin
from firebase_admin import credentials
from firebase_admin import storage
from google.cloud import storage

cred = credentials.Certificate('./haha.json')
firebase_admin.initialize_app(cred, {
    'storageBucket': 'haha7414la.appspot.com'
})

def upload_blob(bucket_name, source_file_name, destination_blob_name):
    """Uploads a file to the bucket."""
    # The ID of your GCS bucket
    # bucket_name = "your-bucket-name"
    # The path to your file to upload
    # source_file_name = "local/path/to/file"
    # The ID of your GCS object
    # destination_blob_name = "storage-object-name"
    storage_client = storage.Client()
    bucket = storage_client.bucket(bucket_name)
    blob = bucket.blob(destination_blob_name)

    blob.upload_from_filename(source_file_name)

    print(
        "File {} uploaded to {}.".format(
            source_file_name, destination_blob_name
        )
    )

if __name__ == '__main__':
    upload_blob("haha7414la.appspot.com",'./towa.jpg','0905/1')
    upload_blob("haha7414la.appspot.com", './ayame.jpg', '0905/2')


