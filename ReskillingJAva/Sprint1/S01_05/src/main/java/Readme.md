# Introduction

In this task, some exercises add functionalities to the previous one,
so many of the packages will use classes from others, and almost all of them will use common methods from the `Utils` class of the `auxiliar` package.

## Exercises

### n1Exercise1: List Files and Directories

- **Description**: Displays the files and directories contained within a directory.
- **Execution from the terminal**: We can pass the directory as a parameter.
    - Example: `java Main.java C:\Temp`
- **Execution without arguments or from the IDE**: The program will ask us for the directory we want to list.

### n1Exercise2: Directory Tree

- **Description**: Displays a directory tree starting from a given directory.
- **Execution from the terminal**: We can pass the directory as a parameter.
    - Example: `java Main.java C:\Temp`
- **Execution without arguments or from the IDE**: The program will ask us for the directory to explore.

### n1Exercise3: Save Directory Tree

- **Description**: Adds the functionality of saving the directory tree to a `.txt` file to the previous exercise.
- **Execution from the terminal**:
    - `-d` to display the directory tree.
    - `-s` to save it to the `dirtree.txt` file in the `output` directory.
    - Examples:
        - `java Main.java -d c:\temp`
        - `java Main.java -s c:\temp`
- **Execution without arguments or from the IDE**: A menu with different options will be displayed.

### n1Exercise4: Read .txt Files

- **Description**: Adds the functionality of reading a `.txt` file.
- **Execution from the terminal**:
    - `-r` to read a `.txt` file that we pass as a parameter.
    - Example: `java Main.java -r c:\temp\file.txt`
- **Execution without arguments or from the IDE**: The option to read a `.txt` file is added, the program will ask for the path, show a list of files in that path, and ask to enter the name of one of them (must be `.txt`).

### n1Exercise5: Serialize and Deserialize Files

- **Description**: Adds the options to serialize and deserialize a file.
- When serializing, a file with the same name as the original, adding the extension `.ser`, will be saved in the `serFiles` directory. To deserialize, we must enter a file already saved in the directory.
- **Execution from the terminal**:
    - `-ser` to serialize.
    - `-dser` to deserialize.
    - Examples:
        - `java Main.java -ser c:\temp\file.txt`
        - `java Main.java -dser file.txt.ser`
- **Execution without arguments or from the IDE**: The options to serialize and deserialize are added to the menu. The program will ask for the path and show a list of files to choose which one to serialize. The serialized files will be saved in the `serfiles` directory with the `.ser` extension. To deserialize, a list of files in the `serfiles` directory will be shown and one must be chosen to display its data.

### n2Exercise1: Record Directory Tree to a File

- **Description**: Records a directory tree in a file named `dirtree.n2Exercise1.txt` in the `output` directory.
- **Configuration**: The directory to explore and the name of the output file are passed through the `conf.properties` configuration file located in the `properties` directory.
- **Execution**: The functionality is the same whether executed from the terminal or the IDE.
    - Example: `java Main.java`

### n3Exercise1: Encrypt and Decrypt Files

- **Description**: A small application to encrypt and decrypt files. Encrypted files are saved in the `encryptedfiles` directory, adding the prefix `enc_`. When decrypting, a file from this directory is requested and saved with the prefix `dec_`.
- **Execution from the terminal**:
    - `-enc` to encrypt.
    - `-dec` to decrypt.
    - Examples:
        - `java Main -enc c:/temp/file.txt`
        - `java Main -dec enc_file.txt`
- **Execution without parameters or from the IDE**: A menu with two options will be displayed. When encrypting, the path is requested and a list of files is shown to choose from. Encrypted files are saved in the `encryptedfiles` directory. When decrypting, a list of files in `encryptedfiles` is shown and one is chosen to decrypt and save with the prefix `dec_`.
