# API

## FileHandler
### Constructors
| Return | Parameters | Description |
|--------|------------|-------------|
| Result | String fileName | Returns a Result object that contains data from the file. If the file is not found, a "FileNotFound" exception will be thrown.|

## Static methods
|Return | Method | Parameters | Description |
|--------|-----------|------------|----------|
| DB | connectMYSQL | String address, String user, String password | Returns a connection to a MySQL database, either local or remote. If the username and/or password is wrong, a "Login exception" will be thrown. |
| Result | getJSON | String fileName | Opens a JSON file, that can be accessed as a Result. If the the file is not found, a FileNotFound exception will be thrown.|
| Result | getXML | String fileName | Opens a XML file, that can be accessed as a Result. If the the file is not found, a FileNotFound exception will be thrown. |

## Result
### Methods
| Return | Method | Parameters | Description |
|--------|--------|------------| ------------|
| Result | getByTag()|String tagName| Returns the element(s) within the tag. If the tag is not found, a "TagNotFound" exception will be thrown.|
| Result | changeValue() | String newValue | Sets the value in the current element to the new value. |
| String | getPath() | - | Returns the path to the value(s) that are active, in the format of directory paths. For example "\<fileName\>/Norway/Østfold/Halden" where Halden is the current selected field. |
| void | setValue() | String newValue | Sets the value in the active field to the newValue. |
| void | setValue() | String newValue, String path | Sets the value in any part of the file to the value. |
| void | addValue() | String key, String value | Adds a new entry in the current location in the file, with key as a reference and the value as the value. |
| void | addValue() | TreeNode values, Field key | Adds the values in the tree to the current location in the file. This requires that the structure is a tree, and therefore not contains a cycle. |
| void | append() | TreeNode values | Adds the values to the end of the file, structured as the tree is. |



[comment]:(TODO: hente ut et felt generelt av en instanse) [/comment]