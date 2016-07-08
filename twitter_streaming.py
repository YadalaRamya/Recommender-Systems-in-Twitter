#Import the necessary methods from tweepy library
from tweepy.streaming import StreamListener
from tweepy import OAuthHandler
from tweepy import Stream

#Variables that contains the user credentials to access Twitter API 
access_token = "2355068298-GAGU17jWgSHQ8aBFPHJWEZwpGCdqCssIEY0T9Hy"
access_token_secret = "1mBTrui1yNKRYpDxV92HrIb1d4WoD3augjKQKsHMT4Sgl"
consumer_key = "7xN08XjPRxkgYGTjWAvzn1xob"
consumer_secret = "2dp1ghREGqJHhI7elKmokleRHPG3su5Ad96nK7wQ3PFEvbruUr"


#This is a basic listener that just prints received tweets to stdout.
class StdOutListener(StreamListener):

    def on_data(self, data):
        print data
        return True

    def on_error(self, status):
        print status


if __name__ == '__main__':

    #This handles Twitter authetification and the connection to Twitter Streaming API
    l = StdOutListener()
    auth = OAuthHandler(consumer_key, consumer_secret)
    auth.set_access_token(access_token, access_token_secret)
    stream = Stream(auth, l)

    #This line filter Twitter Streams to capture data by the keywords: 'python', 'javascript', 'ruby'
    stream.filter(track=['python', 'javascript', 'ruby'])
