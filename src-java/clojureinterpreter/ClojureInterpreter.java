package clojureinterpreter;

import java.util.List;
import java.util.Properties;

import org.apache.zeppelin.interpreter.Interpreter;
import org.apache.zeppelin.interpreter.InterpreterContext;
import org.apache.zeppelin.interpreter.InterpreterResult;
import org.apache.zeppelin.interpreter.InterpreterResult.Code;
import org.apache.zeppelin.scheduler.Scheduler;
import org.apache.zeppelin.scheduler.SchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import clojureinterpreter.core;

/**
 *
 */
public class ClojureInterpreter extends Interpreter {
  Logger logger = LoggerFactory.getLogger(ClojureInterpreter.class);
  int commandTimeOut = 600000;
  Object connection;

  static {
    Interpreter.register("clj", ClojureInterpreter.class.getName());
  }

  public ClojureInterpreter(Properties property) {
    super(property);
  }

  @Override
  public void open() {connection = clojureinterpreter.core.open();}

  @Override
  public void close() {clojureinterpreter.core.close(connection);}


  @Override
  public InterpreterResult interpret(String cmd, InterpreterContext contextInterpreter) {
    return clojureinterpreter.core.interpret(connection,cmd,contextInterpreter);
  }

  @Override
  public void cancel(InterpreterContext context) {}

  @Override
  public FormType getFormType() {
    return FormType.SIMPLE;
  }

  @Override
  public int getProgress(InterpreterContext context) {
    return 0;
  }

  @Override
  public Scheduler getScheduler() {
    return SchedulerFactory.singleton().createOrGetFIFOScheduler(
        ClojureInterpreter.class.getName() + this.hashCode());
  }

  @Override
  public List<String> completion(String buf, int cursor) {
    return null;
  }

}
