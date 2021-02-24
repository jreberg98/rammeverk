# API

## FileHandler
### Constructors
| Return | Parameters | Description |
|--------|------------|-------------|
| Result | String fileName | Returns a Result object that contains data from the file. If the file is not found, a "FileNotFound" exception is thrown.|

## Result
### Methods
| Return | Method | Parameters | Description |
|--------|--------|------------| ------------|
| Result | getByTag()|String tagName| Returns the element(s) within the tag. If the tag is not found, a "TagNotFound" exception is thrown.|
| Result | changeValue() | String newValue | Sets the value in the current element to the new value. |