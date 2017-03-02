@echo off
cd %~dp0

rmdir /Q /S generated
mkdir generated

set "file=island\pom.xml"
set "class=spoonRewriter.Main."
set /a lineToReplace=116

for %%p in (Nothing,MinusToPlus) do (
    setLocal enableDelayedExpansion

    set processor=%class%%%p

    rem -> Creates repertory for mutated project
    mkdir generated\%%p
    mkdir generated\%%p\src\main\java
    mkdir generated\%%p\src\main\resources
    mkdir generated\%%p\src\test
    mkdir generated\%%p\maps
    xcopy island\src\test generated\%%p\src\test\ /E /Q > nul
    xcopy island\maps generated\%%p\maps\ /E /Q > nul
    xcopy island\src\main\resources generated\%%p\src\main\resources /E /Q > nul
    xcopy resources\pom.xml generated\%%p\ /E /Q > nul

    rem -> updates pom.xml
    for /f "tokens=1*delims=:" %%a in ('findstr /n "^" "%file%"') do (
    	set nLine=%%a
    	set line=%%b

    	if  !nLine! equ %lineToReplace% (set "line=<processor>%class%%%p</processor>")
    	echo. !line! >> pom.xml.tmp
    )

    copy pom.xml.tmp %file% > nul
    del pom.xml.tmp

    rem -> Mutates island according to current processor 
    call mvn compile

    rem -> Moves generated sources into generated-sources\<processor-name>\src\main\java
    mkdir generated\%%p\src\main\java\fr
    xcopy island\target\generated-sources\spoon\fr generated\%%p\src\main\java\fr\ /E /Q > nul
    rmdir /Q /S island\target\generated-sources\spoon\fr\

    @echo off
)

goto :eof
