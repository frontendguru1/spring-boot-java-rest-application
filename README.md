Cryptography - Password Encryption:

Now since private key is a private key,only the owner knows the private/secret key. 
Public key is known by everyone in the network.

For example A and B want to communicate. B is owner he has private key. Now 
question arise, what key A will use? Can A use a private key of B? Of course not.Private
key is only known by B, but then public key is known by everyone. For Example let's say 
that we have a central repository where you have all public keys.

public keys of all the members in the network, right? So they don't have to basically ask 
B to give you a public key. Everyone knows what is a public key for B. And since it's a 
public key, there's no risk here.


Now, when A wants to send this data, what a will do is A will use B's public key to 
encrypt. The beauty is when B receives the message, B can decrypt with its own private 
key, and only B can do that because B knows the private key

What if C comes in between and say,"Hey, I got the data, now I want to decrypt it."C, 
can't decrypt that with C's private key.It can be only decrypt with the B's private key.


There are different algorithms available for symmetric key, we have algorithm like AES or 
DES. There are multiple algorithms available. Every algorithm have their own strength 
and weaknesses. Same goes for asymmetric key where you have RSA, ECC. So we have 
multiple algorithms available to use. Now depending upon different situation, we can 
use different algorithms and some are faster, some are more secured. So depending 
upon that, you can use any algorithm there.


Let's say A is sending the data to B and say, "Hey, I want to meet at 5:00 PM.“ And 
maybe there's nothing secret here. Okay, so now let's say A want to send a message to 
B by saying, "Hey, let's meet at 5:00 PM.“ And the message is going on the network. 
Now, C comes in between and say, 'Hey, let me just hack that packet and now let me 
send a new packet.“ And C says, "Let's meet at 6:00 PM.“ Now how C will encrypt it? So 
what C will do is, so C will use B's public key, which A also did, and send that message to 
B and B says, "Okay, I got a message and it is encrypted.“ Let me use my private key to 
decrypt.“ Decryption done. So that means I have to meet at 6:00 PM okay? So when 
you are using this cryptography, you are basically encrypting data and decrypting it, 
but there's no way to prove that the sender is the actual sender. So maybe B is thinking 
the message is sent by A, but it is actually sent by C. How do you maintain that identity 
here? Now that's where you can use something called a digital signature.


 So let's say A want to send message to B. First A will use B's public key to encrypt. So first 
layer done. Then the same packet will be encrypted again with A's private key. So 
double encryption.


 Now when the packet goes to B, B says "okay, it is encrypted with A's private key." Let 
me decrypt it with A's public key. Decryption done. That means there's a proof that A 
has sent it. And then again the packet is still encrypted. So again, it will do decryption 
again with B's private key. Because no one knows the B's private key. And now, B got 
the message and we have achieved security as well as identity.



But what if, let's try to attack here. So let's say C comes in between us and say "hey, I 
want to attack now." C receives the package and says "okay just encrypt it with A's 
private key." Let me decrypt it with A's public key. Decryption done. But now your still 
encrypted with B's public key. Can C decrypt it? No. Because C has no idea what's B's 
private key.
