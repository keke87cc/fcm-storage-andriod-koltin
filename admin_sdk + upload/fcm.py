import firebase_admin
from firebase_admin import credentials, messaging

cred = credentials.Certificate("./haha.json")
firebase_admin.initialize_app(cred)


def sendPush(title, msg, image, registration_token, dataObject=None):
    # See documentation on defining a message payload.
    message = messaging.MulticastMessage(
        notification=messaging.Notification(
            title=title,
            body=msg,
            image=image,
        ),
        data=dataObject,
        tokens=registration_token,
    )

    # Send a message to the device corresponding to the provided
    # registration token.
    response = messaging.send_multicast(message)
    # Response is a message ID string.
    print('Successfully sent message:', response)
