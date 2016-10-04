package studyart.utils.dymanic.core;

import studyart.utils.bash.IBash;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * Created by mi on 04.09.16.
 */
public class ExecutionCoreImpl implements ExecutionCore {

    private IBash bash;

    public ExecutionCoreImpl(IBash bash) {
        this.bash = bash;
    }

    @Override
    public String compile(String path) {
        try {
            String result = bash.executeCommand("javac", path);
            System.out.println("Compilation result: " + result);

            String newPath = path.replace(".java", ".class");

            return newPath;
        } catch (ExecutionCommandException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public String execute(String compiledPath) throws ExecutionCommandException {
        Class cl = ExecutionCoreImpl.class;

        try {

            ///home/alex/dev/IdeaProjects/ACP14/resources/alex.mykhailov/Task1.class
            // path.substring(path.lastIndexOf("/"), path.lastIndexOf("."));
            File root = new File(compiledPath.substring(0, compiledPath.lastIndexOf("/"))); // On Windows running on C:\, this is C:\java.
            File compiled = new File(compiledPath);

            // Load and instantiate compiled class.

            // should be a singleton
            URLClassLoader classLoader = URLClassLoader.newInstance(new URL[]{root.toURI().toURL()});
            String className = compiledPath.substring(
                    compiledPath.lastIndexOf('/') + 1, compiledPath.lastIndexOf('.'));

            Class<?> cls = Class.forName(className, true, classLoader); // Should print "hello".

            Method mainRunTestMethod = cls.getMethod("main", String[].class);
            String[] params = null;
            mainRunTestMethod.invoke(null, (Object) params);

            return "success execution";

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
// Save source in .java file.

        throw new ExecutionCommandException("some problem");
    }
}
