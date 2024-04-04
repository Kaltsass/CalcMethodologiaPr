    import javax.xml.parsers.DocumentBuilder;
    import javax.xml.parsers.DocumentBuilderFactory;
    import javax.xml.transform.OutputKeys;
    import javax.xml.transform.Transformer;
    import javax.xml.transform.TransformerFactory;
    import javax.xml.transform.dom.DOMSource;
    import javax.xml.transform.stream.StreamResult;
    import org.w3c.dom.Document;
    import org.w3c.dom.Element;

    import static java.lang.Integer.parseInt;

    public class xmlWriter {
        private static char operatorMain;

        public static void setOperatorMain(char operator) {
            operatorMain = operator;
        }


        public static void writeXML(double num1, double num2) throws Exception  {

            double resultOfArithmeticOperation = 0;


            //Creating document builder
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            //Create new document
            Document myFile = builder.newDocument();

            Element root = myFile.createElement("numericOperation");
            myFile.appendChild(root);

            //Create elements and add context

            Element number1 = myFile.createElement("number1");
            //number1.appendChild(myFile.createTextNode(String.valueOf("num1")));
            number1.setTextContent(String.valueOf(num1));

            Element operator = myFile.createElement("operator");
            //operator.appendChild(myFile.createTextNode("operator "));
            //operator.setTextContent(String.valueOf(operatorMain));

            Element number2 = myFile.createElement("number2");
            number2.appendChild(myFile.createTextNode(String.valueOf(num2)));

            switch (operatorMain) {
                case '+':
                    resultOfArithmeticOperation = num1 + num2;


                    break;

                case '-':
                    resultOfArithmeticOperation = num1 - num2;
                    operator.setTextContent("-");
                    break;

                case '*':
                    resultOfArithmeticOperation = num1 * num2;

                    operator.setTextContent("*");
                    break;

                case '/':
                    if (num2 != 0) {
                        resultOfArithmeticOperation = num1 / num2;

                        operator.setTextContent("/");
                    } else {

                        resultOfArithmeticOperation = Double.NaN;

                    }
                    break;
            };


                Element res = myFile.createElement("Result");
                //res.appendChild(myFile.createTextNode(String.valueOf(resultOfArithmeticOperation)));

                String finalResult = String.valueOf(num1) + "     " + String.valueOf(num2);
                res.setTextContent(finalResult);





                root.appendChild(number1);
                root.appendChild(operator);
                root.appendChild(number2);
                root.appendChild(res);


                //Write to XML file

                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                transformer.setOutputProperty(OutputKeys.INDENT, "yes");
                DOMSource source = new DOMSource(myFile);

                //Specify file path

                StreamResult result = new StreamResult("C:\\Users\\lange\\IdeaProjects\\tests\\Calculator\\src\\tester.xml");
                transformer.transform(source, result);

                System.out.println("XML file created successfully");

            }


    }



