






import pandas as pd
import requests
from io import StringIO

# URL of the online CSV file
csv_url = 'https://docs.google.com/spreadsheets/d/1pD_mbfuONr74iiUM4TUAtUml8E7usfPeXMPqmdkfEsk/edit#gid=0'

# Fetch the data from the URL
response = requests.get(csv_url)
data = StringIO(response.text)

# Read the CSV data into a pandas DataFrame
df = pd.read_csv(data)

# Replace 'ColumnName' with the actual column name from your CSV file
column_name = 'Unnamed: 6'

# Wrap the content of the specified column with double quotes
df[column_name] = df[column_name].apply(lambda x: f'"{x}"' if pd.notnull(x) else '')

# Print the modified DataFrame
print(df.head())

# Note: At this point, the DataFrame is modified in memory. If you want to save it back to the online CSV file, additional steps may be required.

















# import pandas as pd

# # Specify the path to your CSV file
# csv_file_path = 'stationData.csv'

# # Read the CSV file into a pandas DataFrame
# df = pd.read_csv(csv_file_path)

# # Print the existing column names
# print(df.columns)

# # Replace 'ColumnName' with the actual column name from your CSV file
# column_name = 'Unnamed: 10'

# # Wrap the content of the specified column with double quotes
# df[column_name] = df[column_name].apply(lambda x: f'"{x}"' if pd.notnull(x) else '')

# # Save the modified DataFrame back to the CSV file
# df.to_csv(csv_file_path, index=False)

# print('CSV file has been modified successfully.')
