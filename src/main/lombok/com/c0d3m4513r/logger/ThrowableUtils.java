package com.c0d3m4513r.logger;

import org.checkerframework.checker.nullness.qual.Nullable;

public final class ThrowableUtils {
   private ThrowableUtils() {
      throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
   }

   public static String toStringWithStacktrace(Throwable throwable) {
      return toStringWithStacktrace(throwable, new StringBuilder(),"").toString();
   }

   public static StringBuilder toStringWithStacktrace(Throwable throwable, StringBuilder sb, String indent) {
      sb.append(indent).append(throwable.getClass().getName())
              .append(": ")
              .append(throwable.getLocalizedMessage())
              .append("\n");
      for (StackTraceElement element : throwable.getStackTrace()) {
         sb.append(indent)
                 .append("\tat: ")
                 .append(element.toString())
                 .append("\n");
      }
      for (Throwable supressed:throwable.getSuppressed()) {
            sb.append(indent)
                    .append("Suppressed: ")
                    .append("\n");
            toStringWithStacktrace(supressed,sb,indent+"\t");
      }
      @Nullable
      Throwable cause = throwable.getCause();
      if (cause != null) toStringWithStacktrace(cause,sb,indent+"\t");
      return sb;
   }
}
