package ch.heigvd.res.labio.impl.explorers;

import ch.heigvd.res.labio.interfaces.IFileExplorer;
import ch.heigvd.res.labio.interfaces.IFileVisitor;
import java.io.File;

/**
 * This implementation of the IFileExplorer interface performs a depth-first
 * exploration of the file system and invokes the visitor for every encountered
 * node (file and directory). When the explorer reaches a directory, it visits all
 * files in the directory and then moves into the subdirectories.
 * 
 * @author Olivier Liechti
 */
public class DFSFileExplorer implements IFileExplorer {

  @Override
  public void explore(File rootDirectory, IFileVisitor vistor) {
    //throw new UnsupportedOperationException("The student has not implemented this method yet.");
    if(rootDirectory == null)
    {
      return;
    }

    //We invokes visitor.visit on the rootDirectory (file or directory, we don't care)
    vistor.visit(rootDirectory);

    //If rootDirectory is a directory, we call explore on each directory or file in this directory
    File[] childs = rootDirectory.listFiles();
    for(File child : childs) {
      explore(child, vistor);
    }
  }

}
