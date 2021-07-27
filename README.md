## training

### 2021/07/20
* プロトタイプ。とりあえず画面動くことの確認だけ。
* (例外処理やCSSなど考慮しておらず、保守性も×。)
* DB情報はapplication.propertiesで。
* 画面レイアウトは以下のパス。  
/training/src/main/resources/templates/design/画面レイアウト.xlsx

### 2021/07/27
* バリデーション追加
* DB定義を追加  
/training/src/main/resources/training_staffs.sql
* DB定義を一部変更  
joined_yearの型を[VARCHAR(10)]に。  
staff_photo_urlを削除。