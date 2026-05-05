So using Serialization we convert to byte from and deserialization not gurantted will result the same object, 
so to fix this we can use the readresolve method and return the same instance.
Then only we will be able to avoid the serialization issue in singltoen

now comes to reflection, we can get the constructor,modify it and create different object using reflection, to 
avoid this we can use ENUM classes, jvm automatically handles this and give you a singleton class