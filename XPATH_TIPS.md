XPath Techniques & Functions — Practical Cheatsheet

This file collects concise, interview-style XPath techniques, common XPath functions and practical Selenium+Java usage examples using the AutomationPractice table (https://rahulshettyacademy.com/AutomationPractice/).

Keep this as a quick reference when you need reliable locators or when you're asked XPath questions in interviews.

---

Why XPath? When to use it
- Use XPath for powerful tree traversal (parent/ancestor, sibling, text matching).
- Use CSS selectors for simple attribute/class-based queries (faster, cleaner) — but CSS cannot go upward (no parent/ancestor axes) and has limited text support.
- Prefer stable attributes (id, data-*). Use XPath when those aren't available or when text matching is needed.

Core concepts
- Document-scope vs. context-scope:
  - driver.findElements(By.xpath("//tr")) — searches from document root (global).
  - element.findElements(By.xpath(".//tr")) — searches relative to the element (scoped). The leading dot is crucial.

Useful XPath functions & patterns

1) text() vs normalize-space()
- //tag[text()="Exact Text"]  -- exact match (fragile if extra whitespace)
- //tag[normalize-space(text())='Exact Text']  -- trims leading/trailing spaces and collapses runs of whitespace

2) contains(...)
- //tag[contains(text(), 'part of text')]  -- substring match
- //tag[contains(normalize-space(.), 'trimmed substring')]  -- robust for messy whitespace
- attribute usage: //a[contains(@href, 'logout')]

3) starts-with(...)
- //input[starts-with(@id,'user_')]  -- useful for dynamic suffixes

4) index/predicate
- (//table//tr)[1]  -- first matched tr in document-scope (use parentheses for indexing)
- //table//tr[position()=1] or //table//tr[1]  -- first row in that node-set
- //table//tr[last()]  -- last row

5) axes (common interview favorites)
- ancestor::  -- e.g., //td[contains(.,'Name')]/ancestor::tr  (go to parent row)
- parent or ..  -- //td[.='something']/..  (go to the immediate parent)
- following-sibling::  -- //td[.='Name']/following-sibling::td[1]  (next cell)
- preceding-sibling::  -- //td[.='Name']/preceding-sibling::td[1]
- descendant::  -- //div[@id='x']/descendant::a (all anchors under the div)
- self::  -- rarely used directly; refers to the context node

6) combining predicates
- //tr[td[contains(normalize-space(.), 'Selenium')]]/td[2]  -- find tr that contains a td matching 'Selenium' then get its second column

7) selecting attributes
- //input[@type='submit' and @value='Search']
- //button[contains(@class,'primary') and normalize-space(.)='Save']

8) position-based selection with text
- //ul/li[position()=last()-1]  -- second last list item

9) safer text matching
- Use normalize-space to handle newlines/spaces: //td[contains(normalize-space(.), 'text')]

Practical Selenium+Java snippets (short)

Note: replace ChromeDriver setup as needed. These are minimal snippets to copy-paste.

1) Scoped row count (use .// to keep search inside the table):

WebElement table = driver.findElement(By.xpath("//table[@name='courses']"));
int rowsScoped = table.findElements(By.xpath(".//tr")).size();

// If the table uses <tbody> and you only want body rows:
int bodyRows = table.findElements(By.xpath("./tbody/tr")).size();

2) Get price (common interview question: "Find the price for course 'X'")

String courseName = "Selenium Webdriver";
String priceXpath = ".//tr[.//td[contains(normalize-space(.), '" + courseName + "')]]/td[2]";
WebElement priceEl = table.findElement(By.xpath(priceXpath));
String price = priceEl.getText().trim();

3) Click action/button in the same row as the matched text

String actionXpath = ".//tr[.//td[contains(normalize-space(.), '" + courseName + "')]]//a | .//tr[.//td[contains(normalize-space(.), '" + courseName + "')]]//button";
List<WebElement> actions = table.findElements(By.xpath(actionXpath));
if (!actions.isEmpty()) {
    actions.get(0).click();
}

4) From a cell, go to parent row then get siblings

WebElement cell = table.findElement(By.xpath(".//td[contains(normalize-space(.), 'Selenium Webdriver')]");
WebElement row = cell.findElement(By.xpath("ancestor::tr"));
String price2 = row.findElement(By.xpath("./td[2]")).getText();

// or immediate next sibling
String nextCell = cell.findElement(By.xpath("following-sibling::td[1]")).getText();

5) Use contains with attributes

//a[contains(@href, 'checkout')]

6) Use starts-with and dynamic attributes

//input[starts-with(@id,'username_')]

7) Use position() when needed

//table[@id='x']/tbody/tr[position() > 1]  // all rows except header

Interview-style questions & short answers

Q: Why did my element.findElements(By.xpath("//tr")) return rows from other tables?
A: Because "//tr" is evaluated from the document root; use ".//tr" to scope to the element context.

Q: When should I use normalize-space()?
A: When the text may contain leading/trailing spaces or newlines. normalize-space(.) trims and collapses whitespace so contains(normalize-space(.),'Name') is robust.

Q: What is the difference between following:: and following-sibling::?
A: following:: selects nodes after the context node in the document order from anywhere; following-sibling:: limits to sibling nodes with the same parent.

Q: CSS vs XPath — when to prefer one over the other?
A: Prefer CSS for speed and simplicity when selecting by class/id/attributes. Use XPath when you need parent traversal, text() matching, or complex axes.

Q: How to avoid brittle XPaths?
A: Prefer stable attributes (id/data-*), use contains() with classes carefully (classes can reorder), avoid absolute XPaths that rely on full DOM paths. Use relative, semantic locators.

Advanced tips (short)
- Avoid using index-based XPaths like //div[3]/ul/li[2] unless unavoidable. Prefer semantic predicates.
- Use normalize-space(translate(.,'\u00A0',' ')) if you must handle non-breaking spaces.
- If a table is generated dynamically, wait for its presence with explicit waits before querying rows.

Add this file to docs or link it from your README as a quick interview cheat-sheet.

---

If you'd like I can:
- Add this to `XPATH_TIPS.md` in the repo (done) and commit (already created here), or
- Convert the most used snippets into small TestNG tests in `src/test/java` that assert counts/values.

Which next step do you want? Commit message and push, or add tests?