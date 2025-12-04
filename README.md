# -Project-BookManager

# 📚 BookManager

## 專案簡介
BookManager 是一個基於 **Java 終端機** 的書籍管理系統。  
它可以讓使用者管理書籍資料，包括新增、查詢、刪除、統計與存檔功能。  
資料保存在本地文字檔 `books.txt`，程式運行期間保存在記憶體中 (ArrayList<Book>)。

---

## 功能列表

- **新增書籍**：輸入書名、作者、價格，加入記憶體列表  
- **列出書籍**：印出目前所有書籍  
- **搜尋書籍**：依書名或作者關鍵字搜尋  
- **刪除書籍**：依書名刪除書籍  
- **統計書籍數量**：顯示目前書籍總數  
- **存檔**：將記憶體資料寫入 `books.txt`  
- **讀檔**：啟動時自動從 `books.txt` 載入書籍  

---

## 安裝與執行

1. 需要環境：
   - Java JDK 8 以上  
   - IntelliJ IDEA 或其他 Java IDE  

2. 專案結構：
BookManager/
├─ src/
│ ├─ Main.java
│ ├─ Book.java
│ └─ BookManager.java
└─ books.txt （儲存書籍資料）

3. 執行：
   1. 用 IntelliJ 開啟專案  
   2. Run `Main.java`  
   3. 選單操作：
