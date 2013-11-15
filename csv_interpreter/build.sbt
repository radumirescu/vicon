
name := "csv_interpreter"

version := "1.0.1"

initialize ~= { _ =>
  System.setProperty("java.library.path","D:/sandbox/vicon/lib")
}