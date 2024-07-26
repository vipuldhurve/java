## Singleton
- A design pattern that restricts the instantiation of a class to <b>one single object</b>.
- Throughout the lifetime of the application the instance will remain same.
- Class should be sealed and its constructor should be private.
- Instance should be requested instead of created.

### Why we need singleton
- When there is single resource throughout the application, example: database, log file etc.
- When there is a single resource and there is very high chance of deadlock.
- When we want to pass instance from once class to another class.
