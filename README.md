# JSONCopierGetterTool

This program is a tool for copying and retrieving data from JSON files. 
The tool has two main functionalities: 'copy', and 'get'.
The function 'copy' will create a duplicate of a specified JSON file, and store it in a location unknown to the user.
This function is created to support the function 'get', which reads the previously copied file, retrieves data specified by a JSON path, and displays it on screen. 

A command is entered in order to utilise these functionalities; this command can have up to three components, depending on which functionality is required. 

Component 1: 'copy' or 'get'.
The first argument of the command is one of the above keywords. This provides a mode in which the program can operate.

Component 2: the file path ('copy' only), or file key ('get' only).
With 'copy', provide a path to the file, relative to the working directory.
When retrieving information from a previously copied JSON, an identifier flag must be provided in order for the program to access the correct file. This flag can be either '-i' or '--id', and must be followed by an identifier unique to the file, e.g. 'example_id_flag'.
This identifier corresponds with the 'id' field in each JSON.

Component 3: the path to the information to be retrieved ('get' only).
Provide a JSON field to be examined by the tool, and printed to the screen. In the case of a nested field, provide the path to the field.
