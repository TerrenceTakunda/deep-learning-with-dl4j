package controllers.recognizer

import org.scalatest.{FlatSpec, Matchers}

class RecognizerTest extends FlatSpec with Matchers{

  val bestModelPath = "../data/models/drawingNet_v2.zip"
  val recognizer = new Recognizer(bestModelPath)


  "recognise" should "take an array of double from cat drawing, transform it to an NDArray, run predictions and find a cat" in {
    // Given
    val catArray = Array(0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,1,1,1,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.99609375,1,1,1,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,1,1,1,1,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,1,1,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,1,1,1,1,0.203125,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,1,1,1,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.8984375,0.9765625,1,1,1,1,1,1,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,1,1,1,1,0.00390625,1,0.94140625,1,1,1,1,1,1,1,1,1,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,1,1,1,1,1,1,1,1,0.97265625,0.3828125,0.00390625,0.00390625,0.00390625,0.00390625,1,1,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.921875,1,1,1,1,1,1,0.0390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,1,1,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.0546875,1,1,1,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,1,1,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,1,1,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,1,1,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.875,1,1,0.00390625,0.890625,0.00390625,0.00390625,0.00390625,0.00390625,0.94921875,0.59375,0.00390625,0.00390625,0.00390625,1,1,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,1,1,0.00390625,1,1,0.5,0.00390625,0.00390625,0.00390625,1,1,0.00390625,0.00390625,0.00390625,1,1,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,1,1,0.00390625,0.00390625,1,0.00390625,0.00390625,0.00390625,0.00390625,0.328125,0.00390625,0.00390625,0.00390625,1,1,0.5078125,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,1,1,0.00390625,0.78125,1,1,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,1,1,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,1,1,0.00390625,0.05859375,1,1,1,1,1,1,0.00390625,0.00390625,1,1,1,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,1,1,0.00390625,0.00390625,0.00390625,0.98828125,1,1,1,0.44921875,0.00390625,1,1,1,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,1,1,1,0.58203125,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.24609375,1,1,1,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.98046875,1,1,1,1,1,1,1,1,1,1,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,1,1,1,1,1,1,1,0.1796875,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625)
    val expectedCat = (1, Array.fill(10)(1.0))

    // When
    val actualCat = recognizer.recognise(catArray)

    // Then
    actualCat._1 shouldEqual expectedCat._1

  }

  "recognise" should "take an array of double from snake drawing, transform it to an NDArray, run predictions and find a snake" in {
    // Given
    val snakeArray = Array(0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,1,1,1,0.39453125,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.828125,1,1,1,1,1,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.91015625,1,1,1,1,0.5234375,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,1,1,1,1,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,1,1,1,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,1,1,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,1,1,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,1,1,0.5859375,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.2265625,1,1,1,1,0.39453125,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,1,1,1,1,1,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.01953125,1,1,1,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,1,1,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.98828125,1,0.90625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.3203125,1,0.81640625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.33203125,1,1,1,1,1,1,1,1,0.390625,0.140625,0.00390625,0.00390625,0.00390625,0.3359375,1,1,0.72265625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,1,1,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.22265625,0.8671875,0.84375,1,1,1,0.83984375,0.01171875,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,1,1,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,1,1,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625)
    val expectedSnake = (3, Array.fill(10)(1.0))

    // When
    val actualSnake = recognizer.recognise(snakeArray)

    // Then
    actualSnake._1 shouldEqual expectedSnake._1

  }

  "recognise" should "take an array of double, transform it to an NDArray, run predictions and get all the probas" in {
    // Given
    val catArray = Array(0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,1,1,1,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.99609375,1,1,1,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,1,1,1,1,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,1,1,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,1,1,1,1,0.203125,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,1,1,1,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.8984375,0.9765625,1,1,1,1,1,1,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,1,1,1,1,0.00390625,1,0.94140625,1,1,1,1,1,1,1,1,1,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,1,1,1,1,1,1,1,1,0.97265625,0.3828125,0.00390625,0.00390625,0.00390625,0.00390625,1,1,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.921875,1,1,1,1,1,1,0.0390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,1,1,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.0546875,1,1,1,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,1,1,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,1,1,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,1,1,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.875,1,1,0.00390625,0.890625,0.00390625,0.00390625,0.00390625,0.00390625,0.94921875,0.59375,0.00390625,0.00390625,0.00390625,1,1,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,1,1,0.00390625,1,1,0.5,0.00390625,0.00390625,0.00390625,1,1,0.00390625,0.00390625,0.00390625,1,1,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,1,1,0.00390625,0.00390625,1,0.00390625,0.00390625,0.00390625,0.00390625,0.328125,0.00390625,0.00390625,0.00390625,1,1,0.5078125,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,1,1,0.00390625,0.78125,1,1,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,1,1,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,1,1,0.00390625,0.05859375,1,1,1,1,1,1,0.00390625,0.00390625,1,1,1,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,1,1,0.00390625,0.00390625,0.00390625,0.98828125,1,1,1,0.44921875,0.00390625,1,1,1,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,1,1,1,0.58203125,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.24609375,1,1,1,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.98046875,1,1,1,1,1,1,1,1,1,1,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,1,1,1,1,1,1,1,0.1796875,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625,0.00390625)
    val expectedCat = (2, Array.fill(10)(1.0))

    // When
    val actualCat = recognizer.recognise(catArray)

    // Then
    actualCat._2.length shouldEqual expectedCat._2.length
  }


}
