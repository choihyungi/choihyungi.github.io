/*
Open https://script.google.com/
Paste the following CodeBlock.
Adjust 'GoogleSheetsID' and 'SheetName' to your Google Sheet.
Deploy as web app, accessible to anyone.
Use URL in Deployment as link
Adjust URL by adding "?user=" at the end.
*/

// Log phishing simulation clicks to Google Sheet
function doGet(e) {
  const sheet = SpreadsheetApp.openById('GoogleSheetsID').getSheetByName('SheetName');
  
  const timestamp = new Date();
  const userId = e.parameter.user || 'unknown';
  const userAgent = e.parameter.useragent || '';
  
  sheet.appendRow([timestamp, userId, userAgent]);

  // Redirect cleanly to Wikipedia
  const html = '<html><head><meta http-equiv="refresh" content="0; url=https://www.wikipedia.org"/></head><body>Redirecting...</body></html>';
  return HtmlService.createHtmlOutput(html);
}
