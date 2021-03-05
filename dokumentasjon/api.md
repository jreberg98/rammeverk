# API

## FileHandler
### Constructors
| Return | Parameters | Description |
|--------|------------|-------------|
| Result | String fileName | Returns a Result object that contains data from the file. If the file is not found, a "FileNotFound" exception is thrown.|

## Methods
|Return | Method | Parameters | Description |
|--------|-----------|------------|----------|
| DB | connectMYSQL | String address, String user, String password | Returns a connection to a MySQL database, either local or remote. If the username and/or password is wrong, a "Login exception" is thrown. |
| Result | getJSON | String fileName | Opens a JSON file, that can be accessed as a Result. As a Result, the file can be accessed  further. |

## Result
### Methods
| Return | Method | Parameters | Description |
|--------|--------|------------| ------------|
| Result | getByTag()|String tagName| Returns the element(s) within the tag. If the tag is not found, a "TagNotFound" exception is thrown.|
| Result | changeValue() | String newValue | Sets the value in the current element to the new value. |