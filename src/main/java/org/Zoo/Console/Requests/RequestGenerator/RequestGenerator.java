package org.Zoo.Console.Requests.RequestGenerator;

import org.Zoo.Console.Commands.CommandToken;
import org.Zoo.Console.Requests.Request;

public interface RequestGenerator {
    Request generate(CommandToken token);
}
