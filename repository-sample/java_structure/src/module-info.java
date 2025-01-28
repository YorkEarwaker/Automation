module com.example.myapp {
    requires java.sql; // Requires the java.sql module
    exports com.example.myapp.api; // Exports the com.example.myapp.api package
    provides com.example.service.MyService with com.example.service.MyServiceImpl; // Provides a service implementation
	uses com.example.myml.PredictiveAnalytics; // 
	uses com.example.myann.ConvolutionalNeuralNetwork; // 
	uses com.example.mynlp.LargeLanguageModel; // 
}