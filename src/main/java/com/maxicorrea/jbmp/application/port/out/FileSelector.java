package com.maxicorrea.jbmp.application.port.out;

import java.io.File;

public interface FileSelector {

  File selectFileToOpen();

  File selectFileToSave();

}
