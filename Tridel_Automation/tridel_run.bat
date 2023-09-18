set ProjectPath=D:\EclipseWorkspace\Tridel_Automation
cd %ProjectPath%
set classpath=%ProjectPath%\bin;%ProjectPath%\lib\*
echo %classpath%
java org.testng.TestNG %ProjectPath%\testng.xml
pause