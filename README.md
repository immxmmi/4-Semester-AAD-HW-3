
"#Homework 3 – News List"
##Tasks
1. Use a RecyclerView (classical UI) or a LazyColumn (Jetpack Compose), respectively, to display
the news items
- Display the item title in the list
- When clicking a list item, navigate to a details page
2. On the details page show, the
- Unique identifier
- Title
- Description
- Image URL
- Author
- Publication date
- Full article link
- Keywords
3. Load the RSS feed from the internet
- Download the feed in the background.
- Parse the RSS feed into Kotlin data objects.
- Parsing must be done in the background.
- The data object must contain all necessary items (see above). Make sure to use
appropriate data types.
- Implement both parts (downloading and parsing) in a news list view model class.
- Implement an option for reloading the data.
- Sort the news item list by date (newest on top).
4. Use LiveData to update the UI automatically after the data is downloaded and parsed.
##Remarks:
• The UI must be functional. The layout will not be graded as we will implement a refined
layout in the next assignment
• Implement the application using classical Android UI or Jetpack Compose.
##Grading
1. The title of all items is displayed within a RecyclerView or LazyColumn element – 10
2. When clicking a list item, navigation to a details page is triggered. Navigating back to the list
works. – 10
3. The details page contains all required information. – 10
4. RSS feed is correctly downloaded from the internet. – 10
5. All required information is parsed into a Swift dataobject. The data types of the fields were
selected appropriately. – 10
6. Downloading and parsing is implemented in the background. – 10
7. Reloading the data from the server is possible. – 10
8. The order of the news items in the list is correct. – 10
9. Downloading and parsing is implemented in a model object. The UI is updated through
LiveData only. – 20
