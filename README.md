# CRUISE-CONTROL

Cruise control is a small snipped code written in Java that calculates the throttle level based on the cruise speed provided to it.

## Components of Cruise Control
		The cruise control project has the following :
		1. The Throttle Controller interface,
		2. The DefaultThrottleController that implements the ThrottleController interface,
		3. The **Quantizer<T>** interface with a method named **quantize(T)**
		4. The DefaultQuantizer that implements teh QuantizerInterface
		5. The Hysteresis interface 
		6. The DefaultHysteresisImplementation that implements the hysteresis interface.


### The throttle levels are calculated as follows :
``` 

		0 < speed < 10 => throttle level = 1

		11 < speed < 20 => throttle level = 2

		21 < speed < 30 => throttle level = 3

		31 < speed < 40 => throttle level = 4

		41 < speed < 50 => throttle level = 5

		51 < speed < 60 => throttle level = 6

		61 < speed < 70 => throttle level = 7

		speed > 70 => throttle level = 7

		speed < 0 => throttle level = 0

```

