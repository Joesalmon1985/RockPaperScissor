// Again I'm not sure what everything means here, for example enum
public enum Type {
  ROCK {
    @Override
    public boolean beats(Type other) {
      return other == SCISSOR;
    }
  },
  PAPER {
    @Override
    public boolean beats(Type other) {
      return other == ROCK;
    }
  },
  SCISSOR {
    @Override
    public boolean beats(Type other) {
      return other == PAPER;
    }
  };

/* Ah this is what does the error checking bit, if the user inputs anything but ROCK PAPER or SCISSOR then
 * this always returns NULL. 
 */

  public static Type parseType(String value) {
    if (value.equals("ROCK")) {
      return ROCK;
    } else if (value.equals("PAPER")) {
      return PAPER;
    } else if (value.equals("SCISSOR")) {
      return SCISSOR;
    } else {
      return null;
    }
  }

  public abstract boolean beats(Type other);
}
