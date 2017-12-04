; Script generated by the Inno Setup Script Wizard.
; SEE THE DOCUMENTATION FOR DETAILS ON CREATING INNO SETUP SCRIPT FILES!

#define MyAppName "JEquity"
#define MyAppVersion "2017.0.0.39"
#define MyAppPublisher "Beowurks"
#define MyAppURL "http://jequity.sourceforge.net/"
#define MyAppExeName "JEquity.exe"

[Setup]
; NOTE: The value of AppId uniquely identifies this application.
; Do not use the same AppId value in installers for other applications.
; (To generate a new GUID, click Tools | Generate GUID inside the IDE.)
AppId={{6CF3519C-8A1B-4BE1-850D-5EC3E78DABC5}
AppName={#MyAppName}
AppVersion={#MyAppVersion}
;AppVerName={#MyAppName} {#MyAppVersion}
AppPublisher={#MyAppPublisher}
AppPublisherURL={#MyAppURL}
AppSupportURL={#MyAppURL}
AppUpdatesURL={#MyAppURL}
DefaultDirName={pf}\{#MyAppName}
DisableProgramGroupPage=yes
LicenseFile=D:\IntelliJ\JEquity\license\Eclipse Public License.rtf
OutputDir=D:\IntelliJ\JEquity\out\artifacts
OutputBaseFilename={#MyAppName}-{#MyAppVersion}-windows64
Compression=lzma
SolidCompression=yes
ArchitecturesInstallIn64BitMode=x64

; Setup will look in the registry to see if the same application is already installed, and if so, 
; it will use the directory of the previous installation as the default directory presented to the user in the wizard.
; And the user will not be prompted to change the installation directory.
UsePreviousAppDir=yes

; This determines if Inno Setup's automatic uninstaller is to be included in the installation.
Uninstallable=yes

[Languages]
Name: "english"; MessagesFile: "compiler:Default.isl"

[Tasks]
Name: "desktopicon"; Description: "{cm:CreateDesktopIcon}"; GroupDescription: "{cm:AdditionalIcons}"; Flags: unchecked

[Files]
Source: "D:\IntelliJ\JEquity\out\artifacts\JEquity\bundles\JEquity\JEquity.exe"; DestDir: "{app}"; Flags: ignoreversion;
Source: "D:\IntelliJ\JEquity\out\artifacts\JEquity\bundles\JEquity\*"; DestDir: "{app}"; Flags: ignoreversion recursesubdirs createallsubdirs
; NOTE: Don't use "Flags: ignoreversion" on any shared system files

[Icons]
Name: "{commonprograms}\{#MyAppName}"; Filename: "{app}\{#MyAppExeName}"
Name: "{commondesktop}\{#MyAppName}"; Filename: "{app}\{#MyAppExeName}"; Tasks: desktopicon

[Run]
Filename: "{app}\{#MyAppExeName}"; Description: "{cm:LaunchProgram,{#StringChange(MyAppName, '&', '&&')}}"; Flags: nowait postinstall skipifsilent

